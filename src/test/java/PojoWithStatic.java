import java.util.ArrayList;
import java.util.List;

public class PojoWithStatic {

    private static List<TraceString> staticArr = new ArrayList<>();

    public static void addVal(String val) {
        TraceString str = new TraceString(val);
        staticArr.add(str);
    }

    public static List<TraceString> getStaticArr() {
        return staticArr;
    }

    public static void clear() {
        staticArr.clear();
    }

    public static void selfDestroy() {
        staticArr = null;
    }
}
