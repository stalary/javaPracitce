import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<FilterDTO> list = new ArrayList<>();
        list.add(new FilterDTO(122L, true));
        list.add(new FilterDTO(23132L, true));
        list.add(new FilterDTO(2323L, false));
        System.out.println(JSONObject.toJSON(list));
    }

    @Data
    public static class FilterDTO {
        private Long id;

        private Boolean isLegal;

        public FilterDTO(Long id, Boolean isLegal) {
            this.id = id;
            this.isLegal = isLegal;
        }


    }

}