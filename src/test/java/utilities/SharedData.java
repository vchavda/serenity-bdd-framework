package utilities;

import org.springframework.stereotype.Component;

@Component
public class SharedData     {

    public String getSomeSharedData() {
        return someSharedData;
    }

    public void setSomeSharedData(String someSharedData) {
        this.someSharedData = someSharedData;
    }

    private String someSharedData;

}
