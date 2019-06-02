<html lang="zh-cmn-Hans">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/bootstrap-4.0.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap-4.0.0-dist/css/bootstrap-table.css">
    <link rel="stylesheet" href="/mycss/index.css">
    <title>专家待处理案件</title>
</head>

<body>
<header>
    <div class="navbar navbar-expand-sm bg-light navbar-light">
        <a class="navbar-brand col-sm-2" href="index">诉访分离与随案<br/>风险排查</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="container">
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#">首页</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="index">课题一</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">课题二</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">课题三</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">课题四</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">课题五</a>
                    </li>
                </ul>
                <ul class="navbar-nav navbar-right ml-auto">
                    <li class="nav-item">
                        <a href="#">登录</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>
<main>
    <div class="row">
        <div class="col-sm-2 mt-3" id="left">
            <div class="navbar navbar-light text-center">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index">案件信息</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="expert_table">专家待处理案件</a>
                    </li>
                    <!-- <li class="nav-item">
                        <a class="nav-link" href="expert_dod" >专家评判</a>
                    </li> -->
                </ul>
            </div>
        </div>
        <div class="col-sm-9 ml-1" id="content">
            <div id="exp">
                <!-- <form class="form-inline float-right">
                            <div class="form-group row mr-3">
                                <input class="form-control mr-sm-2" type="search" placeholder="键入关键词进行搜索">
                                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">搜索</button>
                            </div>
                        </form> -->
                <table class="table table-striped" id="table-info">
                    <!-- <thead>

                            </thead>
                            <tbody>

                            </tbody>  -->
                </table>

                <!-- 模态框 -->
                <div class="modal fade" id="myModal">
                    <div class="modal-dialog  modal-lg">
                        <div class="modal-content">

                            <!-- 模态框头部 -->
                            <div class="modal-header">
                                <h4 class="modal-title">专家评判</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- 模态框主体 -->
                            <div class="modal-body">
                                <h5>案件信息</h5>
                                <hr/>
                                <form class="form-horizontal" role="form" id="form-exp">
                                    <div class="form-group row pt-2 pb-3">
                                        <label
                                                class="control-label ml-5">案&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="caseId"
                                                   readonly="readonly ">
                                            <!-- <p class="form-control-static">email@example.com</p> -->
                                        </div>
                                        <label
                                                class="control-label ml-5">案&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;由:</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="case-reason"
                                                   readonly="readonly ">
                                        </div>
                                    </div>
                                    <div class="form-group row pt-2 pb-3">
                                        <label class="control-label ml-5">案件类型:</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="case-type"
                                                   readonly="readonly ">
                                        </div>
                                        <label class="control-label ml-5">案件状态:</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="case-state"
                                                   readonly="readonly ">
                                        </div>
                                    </div>
                                    <div class="form-group row pt-2 pb-3">
                                        <label class="control-label ml-5">当前风险等级:</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="letterLevel"
                                                   readonly="readonly ">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>案件详情</label>
                                        <textarea class="form-control" rows="8" style="overflow:scroll"
                                                  id="case-details" readonly="readonly "></textarea>
                                    </div>
                                    <h5>专家编辑区
                                        <hr/>
                                    </h5>
                                    <div class="form-group row pt-2 pb-3">
                                        <label class="control-label ml-5">案件分类:</label>
                                        <div class="col-sm-4">
                                            <select class="form-control" id="case-class">
                                                <option>信访</option>
                                                <option>诉讼</option>
                                            </select>
                                        </div>
                                        <label class="control-label ml-5">风险等级:</label>
                                        <!-- <a class="ml-5" href="#" data-toggle="tooltip" title="风险等级可分为4级：0级-普通信访无风险、1级-集体访风险、2级-越级访风险、3级-进京访风险">风险等级：</a> -->
                                        <div class="col-sm-4">
                                            <select class="form-control" id="case-danger">
                                                <option>普通信访</option>
                                                <option>集体访风险</option>
                                                <option>越级访风险</option>
                                                <option>进京访风险</option>
                                                <option>诉讼案件无该等级划分</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div style="text-align:center">
                                        <button class="btn btn-primary text-center col-md-4"
                                                type="submit">提交
                                        </button>
                                    </div>
                                </form>
                            </div>

                            <!-- 模态框底部 -->
                            <!-- <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                            </div> -->

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</main>
<footer class="text-center text-muted py-4">
    Copyright @Cvlab UESTC2019
</footer>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/bootstrap-4.0.0-dist/others/jquery-3.4.0.min.js"></script>
<script src="/bootstrap-4.0.0-dist/others/popper.min.js"></script>
<script src="/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
<script src="/bootstrap-4.0.0-dist/js/bootstrap-table.js"></script>
<script src="/bootstrap-4.0.0-dist/js/bootstrap-table-zh-CN.js"></script>
<script src="/js/expert.js"></script>
</body>

</html>