public interface Hello {
    public void foo();
    default void fooahaha() {
        System.out.println("Hello ahahah");
    }
}
