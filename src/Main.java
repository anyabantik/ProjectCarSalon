
import Cars.Bus;
import Cars.RegularCar;
import Cars.Truck;
import Enums.BusEnums.*;
import Enums.Options;
import Enums.RegularCar.*;
import Enums.TruckEnums.*;
import Exceptions.FactoryNotFoundException;
import Factories.BusFactory;
import Factories.Factory;
import Factories.RegularCarFactory;
import Factories.TruckFactory;
import Service.*;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ServiceList serviceList = new ServiceList();

        Factory busFactory1 = new BusFactory("Bus factory 1", serviceList);
        Factory truckFactory1 = new TruckFactory("Truck factory 1", serviceList);
        Factory regularCarFactory1 = new RegularCarFactory("Car factory 1", serviceList);

        List<Factory> factoryList1 = new ArrayList<>();
        factoryList1.add(busFactory1);
        factoryList1.add(truckFactory1);
        factoryList1.add(regularCarFactory1);

        Salon salon1 = new Salon(serviceList, factoryList1);


        busFactory1.info();
        busFactory1.showStorage();
        try {
            System.out.println();
            Bus bus = salon1.orderBus(BusModels.NEOPLAN, BusColors.BLACK, BusEngines.BUS_ENGINE_1
                    , BusWheels.R20, BusSeats.MEDIUM, Options.CRUISE_CONTROLE);
            System.out.println(bus + "\n");
            busFactory1.showStorage();
            salon1.serviceBus(bus, null, BusWheels.R25, true, null);
            System.out.println(bus + "\n");
            salon1.serviceBus(bus, null, BusWheels.R25, true, Options.NAVIGATION);
            System.out.println(bus + "\n");
        } catch (FactoryNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        truckFactory1.info();
        truckFactory1.showStorage();
        try {
            System.out.println();
            Truck truck = salon1.orderTuck(TruckModels.MAZ, TruckColors.WHITE, TruckEngines.TRUCK_ENGINE_2
                    , TruckWheels.R22, TruckTonnage.REGULAR_LOAD, Options.RETARDER, Options.CRUISE_CONTROLE);
            System.out.println(truck + "\n");
            regularCarFactory1.showStorage();
            salon1.serviceTruck(truck, TruckColors.BLACK, TruckWheels.R35, true, Options.NAVIGATION);
            System.out.println(truck + "\n");

        } catch (FactoryNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        regularCarFactory1.info();
        regularCarFactory1.showStorage();
        try {
            System.out.println();
            RegularCar car = salon1.orderRegularCar(RegularCarModels.VW, RegularCarColors.BLACK, RegularCarEngines.CAR_ENGINE_1
                    , RegularCarWheels.R15, RegularCarType.REGULAR);
            System.out.println(car + "\n");
            regularCarFactory1.showStorage();
            salon1.serviceRegularCar(car, null, null, true, null);
            System.out.println(car + "\n");
            salon1.serviceRegularCar(car, null, RegularCarWheels.R17, true, Options.NAVIGATION, Options.CRUISE_CONTROLE);
            System.out.println(car + "\n");
            salon1.serviceRegularCar(car, null, RegularCarWheels.R17, false, Options.NAVIGATION);
            System.out.println(car + "\n");
        } catch (FactoryNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        Factory busFactory2 = new BusFactory("Bus factory 2"
                , serviceList
                , new BusModels[]{BusModels.VANHOOL}
                , new BusColors[]{BusColors.WHITE}
                , new BusEngines[]{BusEngines.BUS_ENGINE_1}
                , new BusWheels[]{BusWheels.R20});


        List<Factory> factoryList2 = new ArrayList<>();
        factoryList1.add(busFactory2);
        Salon salon2 = new Salon(serviceList, factoryList2);

        try {
            System.out.println();
            Bus bus = salon2.orderBus(BusModels.NEOPLAN, BusColors.BLACK, BusEngines.BUS_ENGINE_1, BusWheels.R20, BusSeats.MEDIUM, Options.CRUISE_CONTROLE);
            System.out.println(bus);
        } catch (FactoryNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}