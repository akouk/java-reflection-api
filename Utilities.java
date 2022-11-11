import java.util.*;

public class Utilities {

    public static boolean checkIfClassIsNull(Class<?> c) {
        if (c == null) {
            return true;
        }
        return false;
    }
    public static String objectToString(List<?> l) {
        List<String> objectStrings = new ArrayList<>();
        for (Object o: l) {
            String objectStr = o.toString();
            objectStrings.add(objectStr);
        }
        return String.join(", ", objectStrings);
    }
    public static String classNameToString(List<?> l, int n) {
        List<String> listToSingleStr= new ArrayList<>();
        for (int i=0; i<=n; i++) {
            ObjectAnalysis obj = (ObjectAnalysis) l.get(i);
            String className = obj.getObjectsName();
            listToSingleStr.add(className);
        }
        String lineToStr = objectToString(listToSingleStr);
        return  lineToStr;
    }

    public static int readValueOfN(String args) {
        int num = 0;
        try {
            num = Integer.parseInt(args);
            System.out.println("Reading done! \n");
        } catch (NumberFormatException nfe) {
            System.out.println("ERROR: Can't read the value of N. The third argument isn't a valid number! \n Please enter a valid number!");
            System.exit(1);
        }
        return num;
    }
}