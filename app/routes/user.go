package routes

import (
	"github.com/gin-gonic/gin"
)

func User(group *gin.RouterGroup) {
	group.GET("/ping", func(c *gin.Context) {
		c.JSON(200, gin.H{
			"message": "pong",
		})
	})
}
