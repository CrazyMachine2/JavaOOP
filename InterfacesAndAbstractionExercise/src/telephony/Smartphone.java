package telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        String number = this.numbers.get(0);

        if (number.matches("\\d*")) {
            this.numbers.remove(0);
            return String.format("Calling... %s", number);

        }
        this.numbers.remove(0);
        throw new IllegalArgumentException("Invalid number!");
    }

    @Override
    public String browse() {
        String site = this.urls.get(0);

        if (site.matches("\\D*") || !site.isEmpty()) {
            this.urls.remove(0);
           return String.format("Browsing: %s!", site);
        }
        this.urls.remove(0);
        throw new IllegalArgumentException("Invalid URL!");

    }
}
