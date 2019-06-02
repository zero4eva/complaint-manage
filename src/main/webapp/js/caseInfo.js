'use strict'
var caseNum
    , caseNumInput = $('#casenum')
    , caseNumTrigger = $('#casenum-trigger')
    , form_search = $('#search')
    , form_predict = $('#predict')
    , pattern = /^\([0-9]{0,4}\)渝[\u4e00-\u9fa50-9a-zA-Z]*$/
    , reg = new RegExp(pattern)
    , caseNumError = $('#casenum-input-error');
var caseNumber = $('#caseId')
    , criminalCase = $('#case-type')
    , registerReason = $('#case-reason')
    , judicialProcedure = $('#case-state')
    , classification = $('#classification')
    , danger = $('#danger')
    , details = $('#case-details');

form_search.on('submit', function (e) {
    e.preventDefault();
    // console.log("1:", 1);
    caseNum = caseNumInput.val();
    // if (reg.test(caseNum)) {
    console.log("caseNum:", caseNum);
    // caseNumError.hide();
    // alert("valid");
    $.ajax({
        type: "get",
        url: "/case",
        //rest/...?caseNumber=...json/caseInfo.json
        dataType: "json",
        data: "caseId=" + caseNum,
        //"name="+$("#name").val()+"&id_card="+$("#id_card").val(),
        statusCode: {
            200: function (data) {
                console.log("caseInfo:", data)
                var caseId = data.caseNumber
                    , caseType = data.criminalCase
                    , reason = data.registerReason
                    , state = data.judicialProcedure
                    , caseDetails = data.caseDetails;
                caseNumber.val(caseId);
                criminalCase.val(caseType);
                registerReason.val(reason);
                judicialProcedure.val(state);
                details.val(caseDetails);
            },
            404: function () {
                alert("Don't find this case!");
            },
            500: function () {
                alert("Server error!");
            }
        }
    });
    // }
    // else {
    //     console.log("1:", 1);
    //     caseNumError.show();
    // }
});


form_predict.on('submit', function (e) {
    e.preventDefault();
    // console.log("1:", 1);
    caseNum = caseNumInput.val();
    // if (reg.test(caseNum)) {
    console.log("caseNum:", caseNum);
    // caseNumError.hide();
    // alert("valid");
    $.ajax({
        type: "get",
        url: "/case/predict",
        dataType: "json",
        data: "caseId=" + caseNum,
        statusCode: {
            200: function (data) {
                console.log("caseInfo:", data)
                var dangerAndClass_p = dangerAndClass_pre(data.visitLetterLevel);
                var cc = dangerAndClass_p[0]
                    , d = dangerAndClass_p[1];
                var caseClass = caseClassPre(cc)
                    , caseDanger = dangerPre(d);
                classification.val(caseClass);
                danger.val(caseDanger);
            },
            409: function () {
                alert("Predict failed!\nYou can modify it in recommend list manually!");
            },
            500: function () {
                alert("Server error!");
            }
        }
    });
    // }
    // else {
    //     console.log("1:", 1);
    //     caseNumError.show();
    // }
});

function dangerAndClass_pre(s) {
    if (s === '未信访')
        return '14';
    else if (s === '普通')
        return '00';
    else if (s === '集体')
        return '01';
    else if (s === '越级')
        return '02';
    else if (s === '进京')
        return '03';
}

function caseClassPre(c) {
    if (c === '0')
        return "信访";
    else
        return "诉讼";
}

function dangerPre(c) {
    switch (c) {
        case '0': return "普通信访"; break;
        case '1': return "集体访风险"; break;
        case '2': return "越级访风险"; break;
        case '3': return "进京访风险"; break;
        case '4': return "诉讼案件无该等级划分"; break;
    }
}