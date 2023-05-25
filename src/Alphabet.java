public  class Alphabet implements AlphabetInt {
    private String alphabet;

    public Alphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public int  indexOf(char c) {
        return alphabet.indexOf(c);
    }

    @Override
    public int length() {
        return alphabet.length();
    }

    @Override
    public char charAt(int keyVal) {
        return alphabet.charAt(keyVal);
    }

}
