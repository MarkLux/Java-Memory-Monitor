/**
 *
 * @author lumin
 */
public class TraceString {
    private String val;

    public TraceString(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    protected void finalize() throws Throwable {
        // trace the finalize
        System.out.println("string val of " + val + "is finalizing.");
    }
}
