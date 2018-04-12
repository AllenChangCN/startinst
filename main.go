package main

import ("github.com/gin-gonic/gin")

func main() {
	r := gin.Default()
	gin.SetMode(gin.DebugMode)  // ReleaseMode
	v1 := r.Group("/api/v1/test")
	{
		// test
		v1.GET("/ping", func(c *gin.Context) {
			c.JSON(200, gin.H{
				"message": "pong",
			})
		})
		// user
		v1.GET("/", FetchAllUsers)
		//v1.GET("/:id", FetchSingleUser)
		//v1.PUT("/:id", UpdateUser)
		//v1.DELETE("/:id", DeleteUser)
	}
	r.Run()
}