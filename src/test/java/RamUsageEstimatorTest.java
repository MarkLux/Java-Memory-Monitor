import cn.marklux.memory.RamUsageEstimator;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RamUsageEstimatorTest {

    @Test
    public void testRamMap() {
        System.out.println(ClassLayout.parseClass(Pojo.class).toPrintable());

    }

    @Test
    public void testSize() {
        Pojo p = new Pojo();
        System.out.println(RamUsageEstimator.sizeOf(p));
    }

    @Test
    public void testUnsafe() throws Exception {
        Class<?> unsafeClass = null;
        Unsafe unsafe = null;
        try {
            unsafeClass = Class.forName("sun.misc.Unsafe");
            final Field unsafeField = unsafeClass.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            unsafe = (Unsafe) unsafeField.get(null);
        } catch (Exception e) {
            // Ignore.
        }
        Pojo p = new Pojo();
        Field f = Pojo.class.getDeclaredField("e");
        long eOffset = unsafe.objectFieldOffset(f);
        System.out.println(eOffset);
        if (eOffset > 0L) {
            long eVal = unsafe.getLong(p, eOffset);
            System.out.println(eVal); // 1024
        }
    }


    static class Pojo {
        public int a;
        public String b;
        public int c;
        public boolean d;
        private long e;
        public Object f;

        public Pojo() {
            e = 1024;
        }
    }

    static class Int {
        private int val;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
