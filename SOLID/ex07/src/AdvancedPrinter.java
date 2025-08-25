public class AdvancedPrinter implements Printer, Scanner, Fax {
    @Override
    public void print(String text) {
        System.out.println("Print: " + text);
    }

    @Override
    public void scan(String dstPath) {
        System.out.println("Scan to: " + dstPath);
    }

    @Override
    public void fax(String number) {
        System.out.println("Fax to: " + number);
    }
}
