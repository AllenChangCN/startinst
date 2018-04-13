package resources

import (
	"github.com/gin-gonic/gin"
	"github.com/bwmarrin/snowflake"
	"fmt"
)

type UserResource struct {
}

func (r *UserResource) FetchAllUsers(c *gin.Context) {
	node, err := snowflake.NewNode(1)
	if err != nil {
		fmt.Println(err)
		return
	}
	id := node.Generate()
	c.JSON(200, id)
	return
}