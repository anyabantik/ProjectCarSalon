import CarInfo.BusInfo;
import CarInfo.CarInfo;
import CarInfo.RegularCarInfo;
import CarInfo.TruckInfo;
import Cars.Bus;
import Cars.Car;
import Cars.RegularCar;
import Cars.Truck;
import Enums.BusEnums.*;
import Enums.CarInterfaces.CarColors;
import Enums.CarInterfaces.CarWheels;
import Enums.Options;
import Enums.RegularCar.*;
import Enums.TruckEnums.*;
import Exceptions.CarParameterException;
import Exceptions.CarValidationException;
import Exceptions.FactoryNotFoundException;
import Factories.BusFactory;
import Factories.Factory;
import Factories.RegularCarFactory;
import Factories.TruckFactory;
import Service.*;

import java.util.Arrays;
import java.util.List;

public class Salon {

    private List<Serviceable> services;
    private List<Factory> factories;

    public Salon(ServiceList services, List<Factory> factories) {
        this.services = services.getServiceList();
        this.factories = factories;
    }

    public Bus orderBus(BusModels model, BusColors color, BusEngines engine,
                        BusWheels wheels, BusSeats busSeats, Options... options) throws FactoryNotFoundException {

        if (model == null
                || color == null
                || engine == null
                || wheels == null
                || busSeats == null) {
            throw new NullPointerException();
        }

        CarInfo busInfo = new BusInfo(busSeats);

        for (Factory factory : factories) {
            if (factory instanceof BusFactory) {
                try {
                    return (Bus) factory.orderCar(model, color, engine, wheels, options, busInfo);
                } catch (CarValidationException exception) {
                }
            }
        }
        throw new FactoryNotFoundException("No factories available for this order");
    }

    public Truck orderTuck(TruckModels model, TruckColors color, TruckEngines engine,
                           TruckWheels wheels, TruckTonnage tonnage, Options... options) throws FactoryNotFoundException {

        if (model == null
                || color == null
                || engine == null
                || wheels == null
                || tonnage == null) {
            throw new NullPointerException();
        }

        CarInfo truckInfo = new TruckInfo(tonnage);

        for (Factory factory : factories) {
            if (factory instanceof TruckFactory) {
                try {
                    return (Truck) factory.orderCar(model, color, engine, wheels, options, truckInfo);
                } catch (CarValidationException exception) {
                }
            }
        }
        throw new FactoryNotFoundException();
    }

    public RegularCar orderRegularCar(RegularCarModels model, RegularCarColors color, RegularCarEngines engine,
                                      RegularCarWheels wheels, RegularCarType regularCarType, Options... options) throws FactoryNotFoundException {

        if (model == null
                || color == null
                || engine == null
                || wheels == null
                || regularCarType == null) {
            throw new NullPointerException();
        }

        CarInfo carInfo = new RegularCarInfo(regularCarType);

        for (Factory factory : factories) {
            if (factory instanceof RegularCarFactory) {
                try {
                    return (RegularCar) factory.orderCar(model, color, engine, wheels, options, carInfo);
                } catch (CarValidationException exception) {
                }
            }
        }
        throw new FactoryNotFoundException();
    }

    public void serviceBus(Bus bus, BusColors color, BusWheels busWheels, boolean addOrDeleteOptions, Options... options) {
        if (bus == null) {
            throw new NullPointerException();
        }

        if (color != null) {
            changeColor(bus, color);
        }

        if (busWheels != null) {
            changeWheels(bus, busWheels);
        }

        if (options != null) {
            if (addOrDeleteOptions) {
                addOption(bus, options);
            } else {
                deleteOption(bus, options);
            }
        }
    }

    public void serviceRegularCar(RegularCar car, BusColors color, RegularCarWheels regularCarWheels, boolean addOrDeleteOptions, Options... options) {
        if (car == null) {
            throw new NullPointerException();
        }

        if (color != null) {
            changeColor(car, color);
        }

        if (regularCarWheels != null) {
            changeWheels(car, regularCarWheels);
        }

        if (options != null) {
            if (addOrDeleteOptions) {
                addOption(car, options);
            } else {
                deleteOption(car, options);
            }
        }
    }

    public void serviceTruck(Truck truck, TruckColors color, TruckWheels truckWheels, boolean addOrDeleteOptions, Options... options) {
        if (truck == null) {
            throw new NullPointerException();
        }

        if (color != null) {
            changeColor(truck, color);
        }

        if (truckWheels != null) {
            changeWheels(truck, truckWheels);
        }

        if (options != null) {
            if (addOrDeleteOptions) {
                addOption(truck, options);
            } else {
                deleteOption(truck, options);
            }
        }
    }

    private void changeColor(Car car, CarColors color) {
        try {
            services.stream().filter(serviceable -> serviceable instanceof ColorService).findFirst().get().makeOperation(car, color);
        } catch (CarParameterException e) {
            System.out.println(e.getMessage());
        }
    }

    private void changeWheels(Car car, CarWheels wheels) {

        try {
            services.stream().filter(serviceable -> serviceable instanceof WheelService).findFirst().get().makeOperation(car, wheels);
        } catch (CarParameterException e) {
            System.out.println(e.getMessage());
        }

    }

    private void addOption(Car car, Options... option) {

        Serviceable service = services.stream().filter(serviceable -> serviceable instanceof AddOptionService).findFirst().get();
        Arrays.stream(option).forEach(o -> {
            try {
                service.makeOperation(car, o);
            } catch (CarParameterException e) {
                e.printStackTrace();
            }
        });
    }

    private void deleteOption(Car car, Options... option) {

        Serviceable service = services.stream().filter(serviceable -> serviceable instanceof DeleteOptionService).findFirst().get();
        Arrays.stream(option).forEach(o -> {
            try {
                service.makeOperation(car, o);
            } catch (CarParameterException e) {
                e.printStackTrace();
            }
        });
    }

    public void addFactory(Factory factory) {
        factories.add(factory);
    }

    public void removeFactory(Factory factory) {
        factories.remove(factory);
    }


}