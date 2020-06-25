public class Week {
    public String wString(int num) {
        String str = "星期";
        switch (num) {
            case 1:
                str += "一";
                break;
            case 2:
                str += "二";
                break;
            case 3:
                str += "三";
                break;
            case 4:
                str += "四";
                break;
            case 5:
                str += "五";
                break;
            default:
                str = "無法辨識";
                break;
        }
        return str;
    }
}