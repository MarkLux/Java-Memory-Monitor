import cn.marklux.memory.RamUsageEstimator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RamUsageEstimatorTest {

    @Test
    public void testRamEstimate() {
        Pojo pojo = new Pojo();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        pojo.setNumbers(numbers);
        pojo.setName("mark");
        pojo.setLabel("label");
        System.out.println(RamUsageEstimator.sizeOf(pojo));
        pojo.getNumbers().add(11000);
        System.out.println(RamUsageEstimator.sizeOf(pojo));
    }


    static class Pojo {

        private String name;

        private String label;

        private List<Integer> numbers;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public void setNumbers(List<Integer> numbers) {
            this.numbers = numbers;
        }
    }
}
