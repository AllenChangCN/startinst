package main

import (
	"github.com/gin-gonic/gin"
	"./app/resources"
	"./app/util"
)

func main() {
	util.LoadEnvVars()
	r := gin.Default()
	util.UseJSONLogFormat()
	gin.SetMode(util.GetEnv("APP_MODE", gin.ReleaseMode)) // ReleaseMode

	v1 := r.Group("/api/v1/test")
	{
		// test
		v1.GET("/ping", func(c *gin.Context) {
			c.JSON(200, gin.H{
				"message": "pong",
			})
		})
		u := resources.UserResource{}
		// user
		v1.GET("/gg", u.FetchAllUsers)
	}
	r.Run(":" + util.GetEnv("PORT", "8080"))
}