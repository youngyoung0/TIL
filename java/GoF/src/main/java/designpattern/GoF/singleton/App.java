package designpattern.GoF.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        Setting setting = Setting.getInstance();

        // 리플렉션 사용
        Constructor<Setting> constructor = Setting.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Setting setting1 = constructor.newInstance();
        System.out.println(setting == setting1);

        // 직렬화 & 역직렬화 사용
        Settings settings = Settings.getInstance();
        Settings settings1 = null;
        try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))){
            out.writeObject(settings);
        }

        try(ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))){
            settings1 = (Settings) in.readObject();
        }

        System.out.println(settings == settings1);

        // enum 으로 사용
        // - 리플랙션에 안전한 코드가 됩니다.
        SettingE settingE = SettingE.INSTANCE;

        Constructor<SettingE> constructorE = SettingE.class.getDeclaredConstructor();
        constructorE.setAccessible(true);
        SettingE settingE1 = constructorE.newInstance();
        System.out.println(settingE == settingE1);

    }
}
