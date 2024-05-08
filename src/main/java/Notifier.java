public class Notifier implements Runnable{
    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " Стартовал ");
        try {
            Thread.sleep(1000);
            synchronized (msg){
                msg.setMsg(name + " метод Notifier отработал " );
                msg.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
