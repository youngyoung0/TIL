package designpattern.GoF.singleton;

public class Setting {

    // 이른 초기화 사용하기
//    private static final Setting instace = new Setting();

    private static Setting instace;

    private Setting(){}

    // sychronized 키워드 사용 동기화 체크 단, 성능에 문제가 있을수 있다.
    public static synchronized Setting getInstance(){
        if(instace == null){
            instace = new Setting();
        }
        return instace;
    }


//    // double chcked locking 사용하기
//    private static volatile Setting instace;
//    public static Setting getInstance(){
//        if(instace == null){
//            synchronized (Setting.class){
//                if(instace == null){
//                    instace = new Setting();
//                }
//            }
//        }
//    }
//
//    private static class SettingHolder{
//        private static final Setting instance = new Setting();
//    }
//
//    // static inner 클래스 사용하기
//    public static Setting getInstance(){
//        return SettingHolder.instance;
//    }
}
