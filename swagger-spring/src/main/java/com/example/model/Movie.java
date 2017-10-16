package com.example.model;

import java.util.Objects;
import com.example.model.Actor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Movie
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-15T23:45:57.158+02:00")

public class Movie   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("year")
  private Integer year = null;

  @JsonProperty("actors")
  private List<Actor> actors = null;

  public Movie id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Movie title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Movie year(Integer year) {
    this.year = year;
    return this;
  }

   /**
   * Get year
   * @return year
  **/
  @ApiModelProperty(value = "")


  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Movie actors(List<Actor> actors) {
    this.actors = actors;
    return this;
  }

  public Movie addActorsItem(Actor actorsItem) {
    if (this.actors == null) {
      this.actors = new ArrayList<Actor>();
    }
    this.actors.add(actorsItem);
    return this;
  }

   /**
   * Get actors
   * @return actors
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Actor> getActors() {
    return actors;
  }

  public void setActors(List<Actor> actors) {
    this.actors = actors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Movie movie = (Movie) o;
    return Objects.equals(this.id, movie.id) &&
        Objects.equals(this.title, movie.title) &&
        Objects.equals(this.year, movie.year) &&
        Objects.equals(this.actors, movie.actors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, year, actors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Movie {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    actors: ").append(toIndentedString(actors)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

