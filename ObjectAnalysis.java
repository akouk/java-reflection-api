import java.util.ArrayList;
import java.util.List;

public class ObjectAnalysis {

    String objectsName;
    int objectsDeclaredFields;
    int objectsDeclaredAndInheritedFields;
    int objectsDeclaredMethods;
    int objectsDeclaredAndInheritedMethods;
    int objectsSubTypes;
    int objectsSuperTypes;

    List<Class<?>> superTypes;

    public ObjectAnalysis(String name, int fields, int allFields, int methods, int allMethods, int subTypes,
                          int superTypes, List<Class<?>> superTypesList) {
        this.objectsName = name;
        this.objectsDeclaredFields = fields;
        this.objectsDeclaredAndInheritedFields = allFields;
        this.objectsDeclaredMethods = methods;
        this.objectsDeclaredAndInheritedMethods = allMethods;
        this.objectsSubTypes = subTypes;
        this.objectsSuperTypes = superTypes;
        this.superTypes = superTypesList;
    }

    public String getObjectsName() {
        return objectsName;
    }

    public int getObjectsDeclaredFields() {
        return objectsDeclaredFields;
    }

    public int getObjectsDeclaredAndInheritedFields() {
        return objectsDeclaredAndInheritedFields;
    }

    public int getObjectsDeclaredMethods() {
        return objectsDeclaredMethods;
    }

    public int getObjectsDeclaredAndInheritedMethods() {
        return objectsDeclaredAndInheritedMethods;
    }

    public int getObjectsSuperTypes() {
        return objectsSuperTypes;
    }

    public List<Class<?>> getSuperTypes() {
        return superTypes;
    }

    public void setSubtypes(int subtypes) {
        this.objectsSubTypes = subtypes;

    }
    public int getObjectsSubTypes() {
        return objectsSubTypes;
    }
}