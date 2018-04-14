package routes

import (
	"github.com/gin-gonic/gin"
)

func Auth(group *gin.RouterGroup) {
	group.GET("/login", func(c *gin.Context) {
		c.JSON(200, gin.H{
			"message": "pong",
		})
	})
	group.GET("/register", func(c *gin.Context) {
		c.JSON(200, gin.H{
			"message": "pong",
		})
	})
}
