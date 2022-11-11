import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReflectionMethods {

    public static Class getClass(Object type) {
        System.out.println("Getting class \"" + type + "\" ...");

        try {
            Class c = Class.forName(String.valueOf(type));
            System.out.println("Class \"" + type + "\"" + " founded!");
            return c;

        } catch (ClassNotFoundException e) {
            System.out.println(
                    "ERROR! Class: " + e.getMessage() + " not found. Please provide a full qualified Class name!");
        }
        return null;
    }

    public static List<Field> getDeclaredFields(Class<?> c) {
        System.out.println("Getting  \"" + c.getName() + "\" class's declared fields ...");

        List<Field> declaredFieldsList = new ArrayList<>(Arrays.asList(c.getDeclaredFields()));

        return declaredFieldsList;
    }

    public static List<Field> getDeclaredAndInheritedFields(Class<?> c) {
        System.out.println("Getting \"" + c.getName() + "\" class's declared and inherited fields ...");

        if (Utilities.checkIfClassIsNull(c)) return null;
        List<Field> allFields = new ArrayList<>();

        while (c != null) {
            Collections.addAll(allFields, c.getDeclaredFields());
            c = c.getSuperclass();
        }

        return allFields;
    }

    public static List<Method> getDeclaredMethods(Class<?> c) {
        System.out.println("Getting  \"" + c.getName() + "\" class's declared methods ...");

        List<Method> declaredMethodsList = new ArrayList<>(Arrays.asList(c.getDeclaredMethods()));

        return declaredMethodsList;
    }

    public static List<Method> getDeclaredAndInheritedMethods(Class<?> c) {
        System.out.println("Getting \"" + c.getName() + "\" class's declared and inherited methods ...");

        if (Utilities.checkIfClassIsNull(c)) return null;
        List<Method> allMethods = new ArrayList<>();

        while (c != null) {
            Collections.addAll(allMethods, c.getDeclaredMethods());
            c = c.getSuperclass();
        }

        return allMethods;
    }

    public static List<Class<?>> getSuperTypes(Class<?> c) {
        System.out.println("Getting \"" + c.getName() + "\" class's super - types ...");

        List<Class<?>> superTypesList = new ArrayList<>();
        Class<?> superclassOfC = c.getSuperclass();
        List<Class<?>> interfacesList = getInterfaces(c);
        superTypesList.addAll(interfacesList);

        while (superclassOfC != null) {
            superTypesList.add(superclassOfC);
            superclassOfC = superclassOfC.getSuperclass();
        }

        return superTypesList;
    }
    private static List<Class<?>> getInterfaces(Class<?> c) {
        List<Class<?>> interfacesList = new ArrayList<>();

        while (c != null) {
            Class<?>[] cInterfaces = c.getInterfaces();

            for (Class<?> cInterface : cInterfaces) {
                if (interfacesList.contains(cInterface) == false) {
                    interfacesList.add(cInterface);
                }

                List<Class<?>> superInterfaces = getInterfaces(cInterface);
                for (Class<?> sInterface : superInterfaces) {
                    if (interfacesList.contains(sInterface) == false) {
                        interfacesList.add(sInterface);
                    }
                }
            }
            c = c.getSuperclass();
        }
        return interfacesList;
    }

    public static List<ObjectAnalysis> getSubtypes(List<ObjectAnalysis> list) {
        List<ObjectAnalysis> finalList = new ArrayList<>();

        try {
            for (int i = 0; i < list.size(); i++) {

                Class<?> c = Class.forName(list.get(i).objectsName);

                System.out.println("Class \"" + list.get(i).objectsName + "\" has " + list.get(i).objectsDeclaredFields + " declared fields.");
                System.out.println("Class \"" + list.get(i).objectsName + "\" has " + list.get(i).objectsDeclaredAndInheritedFields + " declared and inherited fields.");
                System.out.println("Class \"" + list.get(i).objectsName + "\" has " + list.get(i).objectsDeclaredMethods + " declared methods.");
                System.out.println("Class \"" + list.get(i).objectsName + "\" has " + list.get(i).objectsDeclaredAndInheritedMethods + " declared and inherited fields.");
                System.out.println("Class \"" + list.get(i).objectsName + "\" has " + list.get(i).objectsSuperTypes + " super - types.");

                int counter = 0;
                for (ObjectAnalysis obj : list) {
                    List<Class<?>> superTypes = obj.getSuperTypes();

                    if (superTypes.contains(c))
                        counter += 1;
                }
                list.get(i).setSubtypes(counter);
                finalList.add(list.get(i));

                System.out.println("Class \"" + list.get(i).objectsName + "\" has " + list.get(i).objectsSubTypes + " sub - types. \n");
            }

        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf.getMessage());
        }
        return finalList;
    }
}