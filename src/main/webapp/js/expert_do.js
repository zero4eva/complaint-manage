'use strict'
var caseNum = $('#caseId')
    , criminalCase = $('#case-type')
    , registerReason = $('#case-reason')
    , judicialProcedure = $('#case-state')
    , classification = $('#case-class')
    , danger = $('#case-danger')
    , details = $('#case-details');
var form = $('#form-exp');

/*$(function expertDo(){
    $.ajax({
        type: "get",
        url: "json/caseInfo.json",
        dataType: "json",
        200 : function (data) {
            console.log("caseInfo:", data)
            var caseId = data.caseNumber
                , caseType = data.criminalCase
                , reason = data.registerReason
                , state = data.judicialProcedure
                , caseDetails = data.caseDetails;
            caseNum.val(caseId);
            criminalCase.val(caseType);
            registerReason.val(reason);
            judicialProcedure.val(state);
            details.val(caseDetails);
        },
        500 : function () {
            alert("Server error!");
        }
    });
});*/

form.on('submit', function (e) {
    e.preventDefault();
    console.log("expert do");
    $.ajax({
        type: "put",
        url: "",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(getJsonData()),
        statusCode: {
            200: function (data) {
                console.log("exp_do-data：", data);
                alert("Modify success!");
            },
            404: function () {
                alert("This case has not been predicted yet!");
            },
            500: function () {
                alert("Server error!");
            }
        }
    });
});

function getJsonData() {
    var c = classification.val()
        , d = danger.val();
    var cd = classification_pro(c) + danger_pro(d);
    console.log("cd", cd);
    var cd_data = {"visitLetterLevel": cd};
    return cd_data;
}

function classification_pro(c) {
    if (c === '信访')
        return '0';
    else
        return '1';
}

function danger_pro(d) {
    switch (d) {
        case '一级':
            return '1';
            break;
        case '二级':
            return '2';
            break;
        case '三级':
            return '3';
            break;
    }
}