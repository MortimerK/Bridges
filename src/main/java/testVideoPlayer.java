public class testVideoPlayer {
    public static void main(String[] args) {
        new Thread(){

            @Override
            public void run() {
                super.run();
                for(;;)
                    System.out.println("testing");
            }
        }.start();

        for(;;)
            System.out.println("test2");
    }
}
