abstract class PairMap{
    protected String keyArray[];
    protected String valueArray[];
    abstract String get(String key);
    abstract void put(String key, String value);
    abstract String delete(String key);
    abstract int length();
}

class Dictionary extends PairMap{
    //저장된 아이템 개수
    private int count;

    Dictionary(int size){
        count = 0;
        keyArray = new String[size];
        valueArray = new String[size];
    }

    @Override
    String get(String key) {
        //keyArray 를 탐색하여 일치하는 key 값을 찾아 해당 value 리턴
        for(int i=0; i< count;i++){
            if (key.equals(keyArray[i]))
                return valueArray[i];
        }

        //keyArray 에 일치하는 key 값 없을 경우 null 리턴
        return null;
    }

    @Override
    void put(String key, String value) {
        boolean isExist = false;
        int i;

        //keyArray, valueArray 가 가득찼을 경우 오류 출력 후 리턴
        //저장된 아이템 개수 변동 없음
        if(count == keyArray.length){
            System.out.println("keyArray, valueArray 가득참");
            return;
        }

        //keyArray 를 탐색하여 일치하는 key 값이 존재하면 value 저장
        //저장된 아이템 개수 +1
        for(i=0; i<count ; i++){
            if(key.equals(keyArray[i])){
                valueArray[i] = value;
                count++;
                return;
            }

        }

        //keyArray 에 일치하는 key 값이 없을 경우 비어있는 공간에 key,value 저장
        //저장된 아이템 개수 +1
        for(i=0; i<keyArray.length;i++){
            if(keyArray[i]==null){
                keyArray[i] = key;
                valueArray[i] = value;
                count++;
                return;
            }
        }
    }

    @Override
    String delete(String key) {
        String result = null;
        //keyArray 를 탐색하여 key 값과 일치하는 key, value 삭제
        //저장된 아이템 개수 -1
        for(int i=0; i< keyArray.length ; i++){
            if (key.equals(keyArray[i])){
                result = valueArray[i];
                keyArray[i] = null;
                valueArray[i] = null;
                count--;
                break;
            }
        }

        //삭제된 value 값 리턴
        return result;
    }

    @Override
    int length() {
        //저장되어있는 아이템 개수 리턴
        return count;
    }
}

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);

        dic.put("황기태","자바");
        dic.put("이재문","파이선");
        dic.put("이재문","C++");

        System.out.println("이재문의 값은 "+dic.get("이재문"));
        System.out.println("황기태의 값은 "+dic.get("황기태"));

        dic.delete("황기태");
        System.out.println("황기태의 값은 "+dic.get("황기태"));
    }
}
