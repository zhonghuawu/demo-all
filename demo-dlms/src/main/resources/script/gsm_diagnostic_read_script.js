
/*
Input Sample :

{
    "assetID":"ALzz7ot8",
    "type":"PERIODIC_READ",
    "argumentKey":"gsmDiagnosticRead",
    "result":[
        {
            "timestamp":1605952808,
            "gsmStatus":2,
            "gsmPsStatus":2,
            "gsmCellId":"19599913",
            "gsmCellLocationId":"195",
            "gsmCellSignalQuality":1,
            "gsmCellBer":3,
            "gsmCellMcc":"525",
            "gsmCellMnc":"02",
            "gsmCellChannelNumber":"2"
        }
    ]
}

*/


RESULT = 'result';
ASSET_ID = 'assetID';
TIMESTAMP = 'timestamp';
GSM_STATUS = 'gsmStatus';
GSM_PS_STATUS = 'gsmPsStatus';
GSM_CELL_ID = 'gsmCellId';
GSM_CELL_LOCATION_ID = 'gsmCellLocationId';
GSM_CELL_SIGNAL_QUALITY= 'gsmCellSignalQuality';
GSM_CELL_BER = 'gsmCellBer';
GSM_CELL_MCC = 'gsmCellMcc';
GSM_CELL_MNC = 'gsmCellMnc';
GSM_CELL_CHANNEL_NUMBER = 'gsmCellChannelNumber';



var meterEventsRAW = msg;
var allMeasurepointsEnos = [];

var standardEventsRAW = meterEventsRAW[RESULT];
for (var i = 0; i < standardEventsRAW.length; i++) {
    var meterReadingEnos =
        {
            "assetId" : meterEventsRAW[ASSET_ID],
            "time" : standardEventsRAW[i][TIMESTAMP],
            "measurepoints": {
                "gsmStatus" : standardEventsRAW[i][GSM_STATUS],
                "gsmPsStatus" : standardEventsRAW[i][GSM_PS_STATUS],
                "gsmCellId" : standardEventsRAW[i][GSM_CELL_ID],
                "gsmCellLocationId" : standardEventsRAW[i][GSM_CELL_LOCATION_ID],
                "gsmCellSignalQuality" : standardEventsRAW[i][GSM_CELL_SIGNAL_QUALITY],
                "gsmCellBer" : standardEventsRAW[i][GSM_CELL_BER],
                "gsmCellMcc" : standardEventsRAW[i][GSM_CELL_MCC],
                "gsmCellMnc" : standardEventsRAW[i][GSM_CELL_MNC],
                "gsmCellChannelNumber" : standardEventsRAW[i][GSM_CELL_CHANNEL_NUMBER]
            }
        }
    allMeasurepointsEnos.push(meterReadingEnos);
}

 tools.resultBuilder.build(true, JSON.stringify(allMeasurepointsEnos));