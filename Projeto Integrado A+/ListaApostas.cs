using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Projeto_Integrado_A_
{
    public partial class ListaApostas : Form
    {
        List<int> Sortiados;
        public ListaApostas()
        {
            InitializeComponent();
            Sortiados = new List<int>();
        }
        IEnumerable<Button> butoes;
       
        private void BUTstar_Click(object sender, EventArgs e)
        {
          
        }

        private void Sorteio2_Load(object sender, EventArgs e)
        {

            butoes = this.Controls.OfType<GroupBox>().First().Controls.OfType<Button>();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
         

            Random rand = new Random();
            int S;
                do{
                     S = rand.Next(00, 99);
                }while (Sortiados.Any(i => i == S));


            foreach (var but in butoes)
            {
                if (but.Text == Convert.ToString(S))
                {
                        but.BackColor = Color.Red;
                }
            }
            TXTsortiados.Text = TXTsortiados.Text + S.ToString("00") + " ";

         }

    }
}
