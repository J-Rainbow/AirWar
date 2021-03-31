# AirWar
#  单例模式
    飞机类
    饿汉模式 采用内部类
    private static class HolderClass{
        private final static Plane instance = new Plane();
    }

    public static Plane getInstance(){
        return HolderClass.instance;
    }
    面板类
    Plane plane = Plane.getInstance();