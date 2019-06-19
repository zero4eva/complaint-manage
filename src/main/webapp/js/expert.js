'use strict'
$(function () {
    $('#table-info').bootstrapTable('destroy');
    $('#table-info').bootstrapTable({
        ajax: function (request) {
            $.ajax({
                type: "GET",
                url: "/recommend/list",
                //json/expert_caseInfo.json
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                statusCode: {
                    200 : function (msg) {
                        request.success({
                            row: msg
                        });
                        console.log("tab-info", msg);
                        $('#table-info').bootstrapTable('load', msg);
                    },
                    500 : function () {
                        alert("Server error!");
                    }
                }
            });
        },
        undefinedText: " ",
        sidePagination: 'server',
        pagination: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: "[5, 10, 15, 20]",

        showToggle: false,
        showRefresh: false,
        showColumns: false,
        search: true,
        clickToSelect: true,

        queryParamsType: "undefined",//设置为 ‘limit’ 则会发送符合 RESTFul 格式的参数.
        queryParams: function (params) {//自定义参数，这里的参数是传给后台
            //            请求服务器数据时，可以通过重写参数的方式添加一些额外的参数. 如果
            //　　　　　　　queryParamsType = 'limit' ,返回参数必须包含limit, offset, search, sort, order 
            //            queryParamsType = 'undefined', 返回参数必须包含: pageSize, pageNumber, searchText, sortName, sortOrder. 
            //            返回false将会终止请求。
            console.log("size:", params.pageSize);
            console.log("page-num:", params.pageNumber);
            return {//这里的params是table提供的
                pageSize: params.pageSize,
                pageNumber:params.pageNumber
                //memberId: $("#searchString_id").val() //搜索框内容，可以自动传到后台，搜索在Mybatis,repository.xml中体现
            };
        },

        columns: [
            {
                title: '案号',
                field: 'caseNumber',
                align: 'center',
                valign: 'middle',
            },
            {
                title: '法院',
                field: 'courtName',
                align: 'center',
                valign: 'middle',
            },
            {
                title: '案件类型',
                field: 'criminalCase',
                align: 'center'
            },
            {
                title: '案件状态',
                field: 'judicialProcedure',
                align: 'center',
            },
            {
                title: '结案案由',
                field: 'closeCause',
                align: 'center',
            },
            {
                title: '结案时间',
                field: 'sluitingsdatum',
                align: 'center',
            },
            {
                title: '审判长',
                field: 'chiefJudge',
                align: 'center',
            },
            {
                title: '推荐专家',
                field: 'experts',
                align: 'center',
            },

            {
                title: '操作',
                field: 'courtNumber',
                align: 'center',
                events: operateEvents1,
                // formatter: operateFormatter,
                formatter: function (value, row, index) {
                    var e = '<button class="btn btn-primary text-center" type="button" id="op" data-toggle="modal" data-target="#myModal">评判</button>'
                    // var e = '<a href="expert_do" id="op">评判</a> ';
                    //console.log("table_caseNum:",row.caseNumber);
                    //edit(\'' + row.caseNumber + '\') onclick="expertDo(caseNumber)
                    //<a href="expert_do?caseNum="+row.caseNumber target="_blank">评判</a>
                    return e;
                }
            }
        ]
    });
});


//**********************expert_do**************************//
var caseNum = $('#caseId')
    , criminalCase = $('#case-type')
    , registerReason = $('#case-reason')
    , judicialProcedure = $('#case-state')
    , classification = $('#case-class')
    , level = $('#letterLevel')
    , danger = $('#case-danger')
    , details = $('#case-details');
var form = $('#form-exp');

window.operateEvents1 = {
    "click #op": function (e, value, row, index) {
        console.log("op:", row.caseNumber);
        var caseNumber = row.caseNumber;
        // window.location.href = "expert_do?caseNum=" + caseNumber;
        $.ajax({
            type: "get",
            url: "/case/prediction",
            //json/caseInfo.json
            dataType: "json",
            data:"caseId=" + caseNumber ,
            statusCode: {
                200: function (data) {
                    console.log("caseInfo:", data)
                    var caseId = data.caseNumber
                        , caseType = data.criminalCase
                        , reason = data.registerReason
                        , state = data.judicialProcedure
                        , dangerLevel = data.visitLetterLevel
                        , caseDetails = data.caseDetails;
                    caseNum.val(caseId);
                    criminalCase.val(caseType);
                    registerReason.val(reason);
                    judicialProcedure.val(state);
                    level.val(dangerLevel);
                    details.val(caseDetails);
                },
                404: function () {
                    alert("This case has not been predicted yet!");
                },
                500: function () {
                    alert("Server error!");
                }
            }
        });
    }
};

form.on('submit', function (e) {
    e.preventDefault();
    $.ajax({
        type: "put",
        url: "/case",
        data: "caseId=" + $('#caseId').val() + "&visitLetterLevel="+ getJsonData(),
        statusCode: {
            200: function (data) {
                console.log("visitLetterLevel:", data);
                alert("Modify success, Thanks!");
                window.location.reload();
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

function GetUrlPara(url) {
    var url = url.toString();
    var arrUrl = url.split("=");
    var caseNum = arrUrl[1];
    return decodeURI(caseNum);
}

function getJsonData() {
    var cd
        , c = classification.val()
        , d = danger.val();
    if (classification_pro(c) === '0') {
        if (danger_pro(d) === '0')
            cd = '普通';
        else if (danger_pro(d) === '1')
            cd = '集体';
        else if (danger_pro(d) === '2')
            cd = '越级';
        else if (danger_pro(d) === '3')
            cd = '进京';
        else if (danger_pro(d) === '4')
            alert("分类与风险类型选择有冲突，请重新选择。");
    }
    else if (classification_pro(c) === '1' && danger_pro(d) === '4')
        cd = '未信访';
    else
        alert("分类与风险类型选择有冲突，请重新选择。");
    console.log("cd", cd);
    // var cd_data = { "visitLetterLevel": cd };
    // console.log("cd_data", cd_data);
    return cd;
}


function classification_pro(c) {
    if (c === '信访')
        return '0';
    else
        return '1';
}

function danger_pro(d) {
    switch (d) {
        case '普通信访': return '0'; break;
        case '集体访风险': return '1'; break;
        case '越级访风险': return '2'; break;
        case '进京访风险': return '3'; break;
        case '诉讼案件无该等级划分': return '4'; break;
    }
}
