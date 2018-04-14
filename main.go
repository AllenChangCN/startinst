package main

import (
	"github.com/gin-gonic/gin"
	"./app/resources"
	"./app/util"
	"./app/middleware"
	_ "./app/models"
)

func main() {
	// 加载 .env
	util.LoadEnvVars()
	r := gin.Default()
	// 设置日志格式
	util.UseJSONLogFormat()
	gin.SetMode(util.GetEnv("APP_MODE", gin.ReleaseMode)) // ReleaseMode

	// 注册模型


	r.Use(middleware.JSONLogMiddleware())
	r.Use(gin.Recovery())
	r.Use(middleware.RequestID(middleware.RequestIDOptions{AllowSetting: false}))
	//r.Use(middleware.Auth())
	r.Use(middleware.CORS(middleware.CORSOptions{}))

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