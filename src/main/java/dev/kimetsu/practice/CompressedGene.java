package dev.kimetsu.practice;

import java.util.BitSet;

public class CompressedGene {

    private BitSet bitSet;
    private int length;

    public CompressedGene(String gene) {
        compress(gene);
    }

    /*
    * Метод compress() последовательно просматривает каждый символ в строке нуклеотидов типа String.Встретив символ A,
    * он добавляет в строку битов 00,встретив C — 01, и т. д.
    * Для класса BitSet логические значения true и false соответствуют значениям 1 и 0 соответственно.
    * Каждый нуклеотид добавляется с помощью двух вызовов метода set().
    * Другимисловами, мы постоянно добавляем 2 новых бита в конец строки битов.
    * Два добавляемых бита определяются типом нуклеотида.
    */
    private void compress(String gene) {
        length = gene.length();
        bitSet = new BitSet(length * 2);
        final String upperCase = gene.toUpperCase();

        for (int i = 0; i < length; i++) {

            final int firstLoc = 2 * i;
            final int secondLoc = 2 * i + 1;

            switch (upperCase.charAt(i)) {
                case 'A' -> {
                    bitSet.set(firstLoc, false);
                    bitSet.set(secondLoc, false);
                }
                case 'C' -> {
                    bitSet.set(firstLoc, false);
                    bitSet.set(secondLoc, true);
                }
                case 'G' -> {
                    bitSet.set(firstLoc, true);
                    bitSet.set(secondLoc, false);
                }
                case 'T' -> {
                    bitSet.set(firstLoc, true);
                    bitSet.set(secondLoc, true);
                }
                default -> throw new IllegalArgumentException("Неизвестный символ!!!!");
            }
        }
    }

    private String decompress() {
        if(bitSet == null) return "";

        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < (length * 2); i+=2) {
            final int firstBit = (bitSet.get(i) ? 1 : 0);
            final int secondBit = (bitSet.get(i + 1) ? 1 : 0);
            final int lastBits = firstBit << 1 | secondBit;

            switch (lastBits) {
                case 0b00 -> {builder.append('A');}
                case 0b01 -> {builder.append('C');}
                case 0b10 -> {builder.append('G');}
                case 0b11 -> {builder.append('T');}
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String gene = "AAAAAAAAAATTTTTTTTTTCCCCCCCGGGGGGGAAAAAAAATGATAGTCATGCATCGATCAGCTACGTACA";
        CompressedGene compressedGene = new CompressedGene(gene);
        String decompressed = compressedGene.decompress();
        System.out.println(decompressed);
        System.out.println(gene.equalsIgnoreCase(decompressed));
    }
    
}
