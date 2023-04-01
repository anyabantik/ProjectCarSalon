package Service;


import java.util.ArrayList;
import java.util.List;

public class ServiceList {

    private final List<Serviceable> serviceList;


    public ServiceList(ColorService colorService, WheelService wheelService
            , AddOptionService addOptionService, DeleteOptionService deleteOptionService) {

        serviceList = new ArrayList<>();
        serviceList.add(colorService);
        serviceList.add(wheelService);
        serviceList.add(addOptionService);
        serviceList.add(deleteOptionService);
    }


    public ServiceList() {
        this(new ColorService(), new WheelService(), new AddOptionService(), new DeleteOptionService());
    }

    public List<Serviceable> getServiceList() {
        return serviceList;
    }
}