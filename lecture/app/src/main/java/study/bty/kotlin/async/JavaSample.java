package study.bty.kotlin.async;

public class JavaSample {
    JavaButton button = new JavaButton(
            new JavaOnClickListener() {
                @Override
                public void onClick() {
                    System.out.println("hello");
                }
            }
    );

//    public static void main(String[] args) {
//        JavaSample sample = new JavaSample();
//        sample.button.onClick();
//    }
}

class JavaButton {
    private JavaOnClickListener callback;

    public JavaButton(JavaOnClickListener callback) {
        this.callback = callback;
    }

    public void onClick() {
        callback.onClick();
    }
}

interface JavaOnClickListener {
    void onClick();
}
