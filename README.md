# AirWar
#  ����ģʽ
    �ɻ���
    ����ģʽ �����ڲ���
    private static class HolderClass{
        private final static Plane instance = new Plane();
    }

    public static Plane getInstance(){
        return HolderClass.instance;
    }
    �����
    Plane plane = Plane.getInstance();