package com.example.slelect_fitnessplan.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slelect_fitnessplan.Model.Plans
import com.example.slelect_fitnessplan.R
import com.example.slelect_fitnessplan.ui.theme.*
import kotlinx.coroutines.selects.select

@Composable
fun ChooseYourPlan(choosePlanList: List<Plans>) {
    var selectedItemId by remember { mutableStateOf(choosePlanList.firstOrNull()?.id ?: -1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {


        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "CHOOSE \n" +
                    "YOUR PLAN",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = colorPrimary,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 35.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Lose weight with the plan that suits you best",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            style = Typography.bodyLarge,
            color = gray_02
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                contentPadding = PaddingValues(5.dp),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {

                items(choosePlanList) { planList ->
                    PlanItemList(
                        id = planList.id,
                        name = planList.name,
                        image = planList.images,
                        isSelected = planList.id == selectedItemId,
                        onItemClick = { selectedItemId = it }
                    )
                }
            }
        }
    }
}

@Composable
fun PlanItemList(
    id: Int,
    name: String,
    image: Int,
    isSelected: Boolean,
    onItemClick: (Int) -> Unit
) {

    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(
                if (isSelected) colorPrimary else gray_light__,
                shape = RoundedCornerShape(35.dp)
            )

            .clickable { onItemClick(id) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center


    ) {
        Spacer(modifier = Modifier.width(20.dp))

        Icon(
            painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .padding(start = 10.dp),
            tint = if (isSelected) white else col_343,


            )
        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = name,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            textAlign = TextAlign.Start,
            style = Typography.bodyLarge,
            color = if (isSelected) white else col_343,

            )

        Spacer(modifier = Modifier.width(20.dp))

        if (isSelected) {
            Icon(
                painterResource(id = R.drawable.ic_check_circle),
                contentDescription = null,
                modifier = Modifier
                    .width(70.dp)
                    .size(20.dp)
                    .padding(end = 30.dp),
                tint = white,
            )
        }

    }

}
