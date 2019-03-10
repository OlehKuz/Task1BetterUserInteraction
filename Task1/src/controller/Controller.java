package controller;

import model.entity.*;
import model.service.DBVehicleTypes;
import model.service.TrainService;

import java.util.ArrayList;
import java.util.List;

import static model.service.TrainBuilderScheme.*;

public class Controller {
    public void run(){
        System.out.println("I have this number of railway vehicles in my garage: "+ DBVehicleTypes.values().length );
        System.out.println("Lets construct a PASSENGER_SLEEPING_TRAIN");

        TrainService trainService = new TrainService();
        List<RailwayVehicle> trainBuildingScheme = trainService.getTrainBuildingScheme(PASSENGER_SLEEPING_TRAIN);
        Train builtTrain = trainService.constructTrain(trainBuildingScheme);
        trainService.printConstuctedTrain(builtTrain);

        List<RailwayVehicle> fal = new ArrayList<>();
        fal.add(DBVehicleTypes.FREIGHT_WAGON.getRailwayVehicle());
        fal.add(DBVehicleTypes.CARRIAGE_BERTH.getRailwayVehicle());
        try{
            trainService.setTrainParts(builtTrain,fal);
        }catch (NotSameTrainFunctionException | WrongTrackSizeException e){
            e.printStackTrace();
        }






    }
}
