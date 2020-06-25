public enum Grade {
    Freshman(1),
    Sophomore(2),
    Junior(3),
    Senior(4);
    private int num;
    Grade(int num) {
        this.num = num;
    }
    public int getNum() {
        return num;
    }
}