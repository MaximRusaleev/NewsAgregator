<#import "parts/common.ftlh" as c>
<@c.pagecommon>
    <h2>Новости</h2>

    <form method="get" action="/news">
        <div class="form-group">
            <input type="text" name="filter" value="${filter?ifExists}">
            <button type="submit" class="btn btn-primary">Найти</button>
        </div>
    </form>

    <div class="table table-striped">
        <table>
            <#list news as news>
                <tr>
                    <td><#if news.urlToImage??><img alt="" src="${news.urlToImage}"
                                                       style="width: 110px; height: 50px;"/></#if></td>
                    <td><a href="${news.url}">${news.title}</a></td>
                </tr>
            <#else>
                Нет новостей
            </#list>
        </table>

    </div>

</@c.pagecommon>