<#import "parts/common.ftlh" as c>

<@c.pagecommon>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Редактировать
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="tag" value="${blogs.tag}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="text" value="${blogs.text}"/>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div>

    <div>

        <table class="table table-striped">

            <tr>
                <td><#if blogs.filename??><img alt="" src="/img/${blogs.filename}"
                                               style="width: 50px; height: 50px;"/></#if></td>
                <td>${blogs.tag}</td>
                <td>${blogs.text}</td>
            </tr>

        </table>
    </div>
</@c.pagecommon>