package resources

import (
	"github.com/gin-gonic/gin"
	"fmt"
	"../util"
)

type UserResource struct {
}

func (r *UserResource) FetchAllUsers(c *gin.Context) {

	id := util.SnowflakeID()
	fmt.Print(id)
	c.JSON(200, id)
	return
}