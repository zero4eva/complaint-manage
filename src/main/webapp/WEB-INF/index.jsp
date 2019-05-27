<html lang="zh-cmn-Hans">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/bootstrap-4.0.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/mycss/index.css">
    <title>司法-课题一</title>
</head>

<body>
    <header>
        <div class="navbar navbar-expand-sm bg-light navbar-light">
            <a class="navbar-brand col-sm-2" href="index">诉访分离与随案<br />风险排查</a>
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
                        <li class="nav-item active">
                            <a class="nav-link" href="index">案件信息</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="expert_table">专家待处理案件</a>
                        </li>
                        <!-- <li class="nav-item">
                            <a class="nav-link" href="expert_dod">专家评判</a>
                        </li> -->
                    </ul>
                </div>
            </div>
            <div class="col-sm-9 ml-5" id="content">
                <div id="info" class="mt-5">
                    <form class="form-horizontal" id="search">
                        <div class="form-group row pt-3 justify-content-center">
                            <input type="search" id="casenum" placeholder="请键入需要查询案件的案号" class="form-control col-sm-6">
                            <button class="btn btn-primary ml-1" id="casenum-trigger" type="submit">查询</button>
                            <div class="input-error pt-1 pb-2 col-sm-7" id="casenum-input-error"
                                style="color:orangered;display:none;font:bold;">案号格式有误，请重新输入。</div>
                        </div>
                    </form>
                    <section>
                        <h5>案件信息</h5>
                        <hr />
                        <form class="form-horizontal" role="form">
                            <div class="form-group row pt-2 pb-3">
                                <label class="control-label ml-5">案&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="caseId" readonly="readonly ">
                                    <!-- <p class="form-control-static">email@example.com</p> -->
                                </div>
                                <label class="control-label ml-5">案&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;由:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="case-reason" readonly="readonly ">
                                </div>
                            </div>
                            <div class="form-group row pt-2 pb-3">
                                <label class="control-label ml-5">案件类别:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="case-type" readonly="readonly ">
                                </div>
                                <label class="control-label ml-5">案件状态:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="case-state" readonly="readonly ">
                                </div>
                            </div>
                            <div class="form-group row pt-2 pb-3">
                                <label class="control-label ml-5">案件分类:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="classification" readonly="readonly ">
                                </div>
                                <label class="control-label ml-5">风险等级:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="danger" readonly="readonly ">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>案件详情</label>
                                <textarea class="form-control" rows="8" style="overflow:scroll"
                                    id="case-details" readonly="readonly "></textarea>
                            </div>

                        </form>
                    </section>

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
    <script src="/js/caseInfo.js"></script>
</body>

</html>