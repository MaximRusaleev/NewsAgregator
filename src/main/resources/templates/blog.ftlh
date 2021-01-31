<#import "parts/common.ftlh" as c>
<#import "parts/pager.ftlh" as p>

<@c.pagecommon>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true"
       aria-controls="collapseExample">
        Добавить новую запись
    </a>




    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="tag" placeholder="Тэг">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="text" placeholder="Введите сообщение"/>
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Выберите файл</label>
                    </div>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>

    <div>
        <table class="table table-striped">
            <#list page.content as blog>
                <tr>
                    <td><#if blog.filename??><img alt="" src="/img/${blog.filename}"
                                                  style="width: 50px; height: 50px;"/></#if></td>
                    <td>${blog.tag}</td>
                    <td><a href="/blog/${blog.id}">${blog.text}</a></td>
                </tr>
            <#else>
                Нет блогов
            </#list>
        </table>
    </div>

    <@p.pager url page />

</@c.pagecommon>

