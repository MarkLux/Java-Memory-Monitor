import cn.marklux.memory.RamUsageEstimator;
import org.junit.Test;

public class GcTest {
    @Test
    public void testStaticGcClear() {
        // fill up:
        for (int i = 0; i < 10000; i++) {
            PojoWithStatic.addVal(String.valueOf(i));
        }
        // usage
        System.out.println("current usage: "
                + RamUsageEstimator.sizeOf(PojoWithStatic.getStaticArr()));
        // clear 1
        PojoWithStatic.selfDestroy();
        System.gc();
        // wait to see if the gc would happen.
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
