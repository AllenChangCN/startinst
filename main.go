package main

import (
	"github.com/gin-gonic/gin"
	"./app/util"
	"./app/middleware"
	"./app/routes"
	_ "./app/models"
)

func main() {
	// 加载 .env
	util.LoadEnvVars()
	r := gin.Default()
	// 设置日志格式
	util.UseJSONLogFormat()
	gin.SetMode(util.GetEnv("APP_MODE", gin.ReleaseMode)) // ReleaseMode

	// 注册Middleware
	r.Use(middleware.JSONLogMiddleware())
	r.Use(gin.Recovery())
	r.Use(middleware.RequestID(middleware.RequestIDOptions{AllowSetting: false}))
	r.Use(middleware.CORS(middleware.CORSOptions{}))

	// 注册路由
	routes.Register(r)

	r.Run(":" + util.GetEnv("PORT", "8080"))
}