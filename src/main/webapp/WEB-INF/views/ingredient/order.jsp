<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<jsp:include page="/WEB-INF/views/common/head.jsp" />
<body class="hold-transition sidebar-mini">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
            $.ajax({
                type: "post",
                url: "Ingredient/selectAll",
                dataType: "json",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                success : function(data, status, xhr) {
                    for ( var i in data.items) {
                        var dto = data.items[i];
                        console.log(dto.name)
                        var html = "";
                        html += '<option value="'+dto.name+'">'+dto.name+'</option>';
                        $("#select_ingre").append(html);
                    }
                }
            }) //select all  -> 데이터 가져오는 용도




        $(".order").on("click",function(){


            var table = []
            var html = '';

            var select = $("#select_ingre").val();
            var quantity = $("#quantity").val();

            html += '<tr>';
            html += '<td width="500">'+select+'</td>';
            html += '<td>'+quantity+'</td>';
            html += '<td width="100"><button class="delete_btn">삭제</button></td>';
            html += '</tr>';


            $("#dynamicTable").append(html);

        });//order


        $(".last_order").on("click",function(){

            Swal.fire({
                title: '발주를 계속 진행하겠습니까?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonText: '취소',
                confirmButtonText: '확인'
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire({
                        title: '발주완료!',
                        text: 'Your file has been completed.',
                        icon: 'success'
                    }).then((result) => {
                        location.href="";
                    })
                }//if
            })//end swal
        });//order




    });//end fn
</script>
<div class="wrapper">
    <!-- Sidebar -->
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />

    <!-- Header -->
    <jsp:include page="/WEB-INF/views/ingredient/common/header.jsp" />

    <!-- Content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">재고관리 Page</h1>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div>
                        <strong>발주</strong> 부족한 재고를 발주 합니다.
                    </div>
                    <table class="table table-striped">
                        <thead>
                        <tr bgcolor="#BDBDBD" font color="white">
                            <th>품명</th>
                            <th>발주 요청 수량</th>
                            <td></td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <select id="select_ingre" class="form-select" aria-label="Default select example">
                                    <option selected>추가하고 싶은 재고를 선택하세요</option>



                                </select>
                            </td>
                            <td>
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="basic-addon1"></span>
                                    <input type="text" id="quantity" class="form-control" placeholder="발주 요청 수량" aria-label="order" aria-describedby="basic-addon1">
                                </div>

                            </td>
                            <td>
                                <div style="width:100px; height:50px; float:right">
                                    <a href="#" class="order"><button type="button" class="btn btn-primary float-right">추가</button></a>
                                </div>
                            </td>
                        </tr>

                        <!--발주 테이블-->
                        <tr>
                        <table class="table table-striped" id="dynamicTable">
                            <thead>
                            <tr>
                                <div>

                                </div>
                                <div>
                                    <strong>발주리스트</strong>
                                </div>
                            </tr>
                            <tr bgcolor="#BDBDBD" font color="white">
                                <th width="500">품명</th>
                                <th>수량</th>
                                <td width="100"></td>
                            </tr>
                            </thead>
                            <tbody id="dynamicTbody">

                            </tbody>
                        </table>
                        </tr>
                        <!--발주 테이블-->

                        </tbody>
                    </table>
                </div>             <!-- /.row -->

                <div style="width:100px; height:50px; float:right">
                    <a href="#" class="last_order"><button type="button" class="btn btn-primary float-right">발주</button></a>
                </div>

                <!--발주 테이블-->


                <!--발주 테이블-->

            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content -->
    </div>

    <!-- Footer -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</div>
</body>
</html>
