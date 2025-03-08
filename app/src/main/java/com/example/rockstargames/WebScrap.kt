package com.example.rockstargames

object WebScrap {
    fun fetchUpdates(callback:(List<UpdateItem>)->Unit)
    {
        Thread{
            try{
                val url = "https://www.rockstargames.com/newswire/tags/152"
                val doc = org.jsoup.Jsoup.connect(url).get()
                val updates = mutableListOf<UpdateItem>()

                val articles = doc.select(".news-item")
                for (article in articles) {
                    val title = article.select("h3.news-item__title").text()
                    val description = article.select("p.news-item__desc").text()
                    val date = article.select("span.news-item__date").text()
                    val imageUrl = article.select("img").attr("data-src")

                    updates.add(UpdateItem(title, date, description, imageUrl))
                }

                callback(updates)
            }
            catch(e:Exception)
            {
                e.printStackTrace()
            }
        }.start()
    }
}