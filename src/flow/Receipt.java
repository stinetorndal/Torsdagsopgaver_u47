package flow;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<ReceiptLine>lines = new ArrayList<>();
    private double total;
    private double VAT;

    public void addLine (ReceiptLine line) {
        lines.add(line);
        total += line.getTotal();
    }

    public void calculateVAT (double rate){
        VAT  = total * rate;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ReceiptLine line : lines) {
            stringBuilder.append(line).append("\n");
        }
        stringBuilder.append("Moms: ").append(String.format("%.2f", VAT)).append("\n");
        stringBuilder.append("Total: ").append(String.format("%.2f", total)).append("\n");
        return stringBuilder.toString();
    }

}
