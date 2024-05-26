package io.nwdaf.eventsubscription.utilities;

import io.nwdaf.eventsubscription.model.GlobalRanNodeId;
import io.nwdaf.eventsubscription.model.Ncgi;
import io.nwdaf.eventsubscription.model.NetworkAreaInfo;
import io.nwdaf.eventsubscription.model.PlmnId;

import java.util.ArrayList;
import java.util.List;

public class TestScenarioConstants {

    public static PlmnId nefPlmnId = new PlmnId().mcc("202").mnc("1");
    public static String nefNrCellIdFormat = "AAAAA100X";
    public static List<Ncgi> nefNrCells = new ArrayList<>(List.of(
            new Ncgi().nrCellId(nefNrCellIdFormat.replace('X', '1')).plmnId(nefPlmnId),
            new Ncgi().nrCellId(nefNrCellIdFormat.replace('X', '2')).plmnId(nefPlmnId),
            new Ncgi().nrCellId(nefNrCellIdFormat.replace('X', '3')).plmnId(nefPlmnId),
            new Ncgi().nrCellId(nefNrCellIdFormat.replace('X', '4')).plmnId(nefPlmnId),
            new Ncgi().nrCellId(nefNrCellIdFormat.replace('X', '5')).plmnId(nefPlmnId)
    ));

    public static String nefGNodeBIdFormat = "LMacroNGeNB-AAAAAX";
    public static List<GlobalRanNodeId> nefGNodeBs = new ArrayList<>(List.of(
       new GlobalRanNodeId().ngeNbId(nefGNodeBIdFormat.replace('X', '1')).plmnId(nefPlmnId)
    ));

    public static NetworkAreaInfo nefServingAOI = new NetworkAreaInfo()
            .ncgis(nefNrCells.subList(0,3))
            .gRanNodeIds(nefGNodeBs);

    public static NetworkAreaInfo nefAOI1 = new NetworkAreaInfo()
            .ncgis(nefNrCells.subList(0, 2))
            .gRanNodeIds(nefGNodeBs);

    public static NetworkAreaInfo nefAOI2 = new NetworkAreaInfo()
            .ncgis(nefNrCells.subList(3, 3))
            .gRanNodeIds(nefGNodeBs);

    /** This AOI is outside the NEF serving AOI */
    public static NetworkAreaInfo nefAOI3 = new NetworkAreaInfo()
            .ncgis(nefNrCells.subList(4, 4))
            .gRanNodeIds(nefGNodeBs);
}
