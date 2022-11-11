import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Process {

    public static void processReflection(List typeName, FileWriter cp, int n){
        System.out.println("Starting process of reflection on type... \n");

        List<ObjectAnalysis> resultsList = new ArrayList<>();

        for (Object type : typeName) {
            constructEachType(resultsList, type);
        }

        List<ObjectAnalysis> finalList = ReflectionMethods.getSubtypes(resultsList);

        createStringBuilderToWriteToOutputFile(cp, n, finalList);
    }

    private static void constructEachType(List<ObjectAnalysis> resultsList, Object type){
        try {
            Class c = ReflectionMethods.getClass(type);
            String typesName = c.getName();
            List<Field> declaredFieldsList = ReflectionMethods.getDeclaredFields(c.forName(typesName));
            List<Field> declaredAndInheritedFieldsList = ReflectionMethods.getDeclaredAndInheritedFields(c.forName(String.valueOf(type)));
            List<Method> declaredMethodsList = ReflectionMethods.getDeclaredMethods(c.forName(String.valueOf(type)));
            List<Method> declaredAndInheritedMethodsList = ReflectionMethods.getDeclaredAndInheritedMethods(
                    c.forName(String.valueOf(type)));
            List<Class<?>> superTypesList = ReflectionMethods.getSuperTypes(c.forName(String.valueOf(type)));

            ObjectAnalysis obj = new ObjectAnalysis(typesName,
                    declaredFieldsList.size(),
                    declaredAndInheritedFieldsList.size(),
                    declaredMethodsList.size(),
                    declaredAndInheritedMethodsList.size(),
                    0,
                    superTypesList.size(),
                    superTypesList);

            resultsList.add(obj);

            System.out.println("Getting \"" + c.getName() + "\" class's subtypes ... \n");

        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }
    }

    private static void createStringBuilderToWriteToOutputFile(FileWriter cp, int n, List<ObjectAnalysis> finalList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = sortListAndGetStringBuilder(n, finalList, stringBuilder);
        FileManager.fileWriting(cp, stringBuilder);
    }

    private static StringBuilder sortListAndGetStringBuilder(int n, List<ObjectAnalysis> fList, StringBuilder strBuilder) {

        Comparator<ObjectAnalysis> declaredFieldsComparator = Comparator
                .comparingInt(ObjectAnalysis::getObjectsDeclaredFields);
        fList.sort(declaredFieldsComparator.reversed());
        strBuilder.append("1a: ").append(Utilities.classNameToString(fList, n-1)).append(System.lineSeparator());

        Comparator<ObjectAnalysis> declaredAllFieldsComparator = Comparator
                .comparingInt(ObjectAnalysis::getObjectsDeclaredAndInheritedFields);
        fList.sort(declaredAllFieldsComparator.reversed());
        strBuilder.append("1b: ").append(Utilities.classNameToString(fList, n-1)).append(System.lineSeparator());

        Comparator<ObjectAnalysis> declaredMethodsComparator = Comparator
                .comparingInt(ObjectAnalysis::getObjectsDeclaredMethods);
        fList.sort(declaredMethodsComparator.reversed());
        strBuilder.append("2a: ").append(Utilities.classNameToString(fList, n-1)).append(System.lineSeparator());

        Comparator<ObjectAnalysis> declaredAllMethodsComparator = Comparator
                .comparingInt(ObjectAnalysis::getObjectsDeclaredAndInheritedMethods);
        fList.sort(declaredAllMethodsComparator.reversed());
        strBuilder.append("2b: ").append(Utilities.classNameToString(fList, n-1)).append(System.lineSeparator());

        Comparator<ObjectAnalysis> subTypes = Comparator.comparingInt(ObjectAnalysis::getObjectsSubTypes);
        fList.sort(subTypes.reversed());
        strBuilder.append("3: ").append(Utilities.classNameToString(fList, n-1)).append(System.lineSeparator());

        Comparator<ObjectAnalysis> superTypes = Comparator.comparingInt(ObjectAnalysis::getObjectsSuperTypes);
        fList.sort(superTypes.reversed());
        strBuilder.append("4: ").append(Utilities.classNameToString(fList, n-1)).append(System.lineSeparator());

        return strBuilder;
    }
}