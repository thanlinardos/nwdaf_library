package io.nwdaf.eventsubscription.responsebuilders;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.nwdaf.eventsubscription.model.*;
import io.nwdaf.eventsubscription.model.NFType.NFTypeEnum;
import io.nwdaf.eventsubscription.utilities.ConvertUtil;
import io.nwdaf.eventsubscription.utilities.ParserUtil;
import io.nwdaf.eventsubscription.model.NwdafEvent.NwdafEventEnum;

import static io.nwdaf.eventsubscription.utilities.ConvertUtil.convertOffsetDateTimeToInstant;
import static io.nwdaf.eventsubscription.utilities.ParserUtil.safeParseOffsetDateTime;

public class NotificationBuilder {
    public NnwdafEventsSubscriptionNotification build(Long subId) {
        return new NnwdafEventsSubscriptionNotification().id(UUID.randomUUID()).subscriptionId(subId.toString());
    }

    @SuppressWarnings("unchecked")
    public <T> NnwdafEventsSubscriptionNotification addEvent(NnwdafEventsSubscriptionNotification self, NwdafEventEnum event, OffsetDateTime start,
                                                             OffsetDateTime expiry, OffsetDateTime timeStampGen, NwdafFailureCode failNotifyCode, Integer rvWaitTime, AnalyticsMetadataInfo anaMetaInfo,
                                                             List<T> infoList) {
        EventNotification e = new EventNotification();
        e.event(new NwdafEvent().event(event)).start(start).expiry(expiry).timeStampGen(timeStampGen).failNotifyCode(failNotifyCode).rvWaitTime(rvWaitTime).anaMetaInfo(anaMetaInfo);
        if (event.equals(NwdafEventEnum.NF_LOAD)) {
            e.nfLoadLevelInfos((List<NfLoadLevelInformation>) infoList);
        } else if (event.equals(NwdafEventEnum.UE_MOBILITY)) {
            e.ueMobs((List<UeMobility>) infoList);
        } else if (event.equals(NwdafEventEnum.UE_COMM)) {
            e.ueComms((List<UeCommunication>) infoList);
        }
        self.addEventNotificationsItem(e);
        return self;
    }

    public <T> List<NfLoadLevelInformation> makeNfLoadLevelInformation(List<List<T>> data, List<List<String>> dataOptionals) {
        List<NfLoadLevelInformation> res = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            NfLoadLevelInformation info = new NfLoadLevelInformation();
            if (dataOptionals.get(i) != null) {
                if (dataOptionals.get(i).get(0) != null) {
                    info.nfType(new NFType().nfType(NFTypeEnum.fromValue(dataOptionals.get(i).get(0))));
                }
                if (dataOptionals.get(i).get(1) != null) {
                    info.nfInstanceId(UUID.fromString(dataOptionals.get(i).get(1)));
                }
                info.nfSetId(dataOptionals.get(i).get(2));
                NfStatus st = new NfStatus();
                if (dataOptionals.get(i).get(3) != null) {
                    st.statusRegistered(Integer.parseInt(dataOptionals.get(i).get(3)));
                }
                if (dataOptionals.get(i).get(4) != null) {
                    st.statusUndiscoverable(Integer.parseInt(dataOptionals.get(i).get(4)));
                }
                if (dataOptionals.get(i).get(5) != null) {
                    st.statusUnregistered(Integer.parseInt(dataOptionals.get(i).get(5)));
                }
                info.nfStatus(st);
                if (dataOptionals.get(i).get(6) != null && dataOptionals.get(i).get(7) != null) {
                    info.snssai(new Snssai().sd(dataOptionals.get(i).get(6)).sst(Integer.parseInt(dataOptionals.get(i).get(7))));
                }
                if (dataOptionals.get(i).get(8) != null) {
                    info.confidence(Integer.parseInt(dataOptionals.get(i).get(8)));
                }
                if (dataOptionals.get(i).get(9) != null) {
                    info.time(convertOffsetDateTimeToInstant(safeParseOffsetDateTime(dataOptionals.get(i).get(9))));
                }

            }
            if (data.get(i) != null) {
                if (data.get(i).get(0) != null) {
                    Integer nfCpuUsage = (Integer) data.get(i).get(0);
                    info.nfCpuUsage(nfCpuUsage);
                }
                if (data.get(i).get(1) != null) {
                    Integer nfMemoryUsage = (Integer) data.get(i).get(1);
                    info.nfMemoryUsage(nfMemoryUsage);
                }
                if (data.get(i).get(2) != null) {
                    Integer nfStorageUsage = (Integer) data.get(i).get(2);
                    info.nfStorageUsage(nfStorageUsage);
                }
                if (data.get(i).get(3) != null) {
                    Integer nfLoadLevelAverage = (Integer) data.get(i).get(3);
                    info.nfLoadLevelAverage(nfLoadLevelAverage);
                }
                if (data.get(i).get(4) != null) {
                    Integer nfLoadLevelPeak = (Integer) data.get(i).get(4);
                    info.nfLoadLevelpeak(nfLoadLevelPeak);
                }
                if (data.get(i).get(5) != null) {
                    Integer nfLoadAvgInAoi = (Integer) data.get(i).get(5);
                    info.nfLoadAvgInAoi(nfLoadAvgInAoi);
                }
                info.areaOfInterestId(null);
            }
            res.add(info);
        }
        return res;
    }
}
